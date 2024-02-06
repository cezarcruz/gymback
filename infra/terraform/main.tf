terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "~> 5.32"
    }
  }

  required_version = ">= 1.6.6"
}

provider "aws" {
  region = "us-east-1"
}

resource "aws_sns_topic" "user_created_topic" {
  name = "user-created-topic"
}