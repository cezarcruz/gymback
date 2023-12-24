//package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import java.util.List;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "class_room_week_days")
//public class ClassRoomWeekDays {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;
//
//  @OneToOne
//  @JoinTable(
//      name = "class_room",
//      joinColumns = @JoinColumn(name = "class_room_id")
//  )
//  private ClassRoomEntity classRoom;
//
//  @ManyToMany
//  @JoinTable(
//      name = "week_day",
//      joinColumns = @JoinColumn(name = "week_day")
//  )
//  private List<WeekDayEntity> weekDays;
//
//}
