/* Under MIT License (C)2024 */
package br.com.gymback.application.config.aspect;

import jakarta.inject.Named;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StopWatch;

@Aspect
@Named
@Slf4j
public class LogAroundAspect {

  @Pointcut(
      "@annotation(org.springframework.web.bind.annotation.PostMapping)" // add get,put or rest
  // packages, etc
  )
  protected void webPointcut() {}

  @Around("webPointcut()")
  public Object logRequest(final ProceedingJoinPoint joinPoint) throws Throwable {

    final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    final String className = methodSignature.getDeclaringType().getSimpleName();
    final String methodName = methodSignature.getMethod().getName();
    final var stopWatch = new StopWatch();

    final Map<String, Object> parameters = getParameters(joinPoint);

    stopWatch.start();

    Object result = joinPoint.proceed();

    stopWatch.stop();

    long elapsedTime = stopWatch.getTotalTimeMillis();
    log.info("request: {}", parameters);
    log.info("class name: {}, path: {}, elapsed time: {} ms", className, methodName, elapsedTime);
    log.info("result: {}", result);
    return result;
  }

  private Map<String, Object> getParameters(final JoinPoint joinPoint) {
    final var signature = (CodeSignature) joinPoint.getSignature();

    final HashMap<String, Object> map = new HashMap<>();

    final String[] parameterNames = signature.getParameterNames();

    for (int i = 0; i < parameterNames.length; i++) {
      map.put(parameterNames[i], joinPoint.getArgs()[i]);
    }

    return map;
  }
}
