
## Coctails-api 🍸
| [Technologies](#-stack) | [Notes](#-some-notes) | [Roles](#-roles) | [External APIs](#-external-apis) | [Setting up a project](#-setting-up-a-project) | [App preview](#-app-preview) | [Envs](#-environment-variables) | [IMPORTANT!](#-important) |
| ----------------------- | --------------------- | ---------------- | -------------------------------- | ---------------------------------------------- | ---------------------------- | ------------------------------- | ------------------------- |

## 🔧 Stack 

![Java](https://img.shields.io/badge/-Java-orange?style=for-the-badge) ![Spring boot](https://img.shields.io/badge/-Spring%20boot-success?style=for-the-badge&logo=spring) ![Hibernate](https://img.shields.io/badge/-Hibernate-%23e6af1b?style=for-the-badge&logo=hibernate) ![PostgreSQL](https://img.shields.io/badge/-PostgreSQL-informational?style=for-the-badge&logo=postgresql) ![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white) ![Angular](https://img.shields.io/badge/-Angular-critical?style=for-the-badge&logo=Angular) ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white) ![Docker](https://img.shields.io/badge/-Docker-9cf?style=for-the-badge&logo=docker) ![Rest API](https://img.shields.io/badge/-Rest%20API-brightgreen?style=for-the-badge&logo=restapi)

## 📄 Some notes 
> **Note** It is a **REST API** application that aims to help the user find recipes to make drinks

At the moment in application we are able to:
- Register and sign in (JWT token included)
- Registration must be confirmed by email

## 🔨 Roles
- USER - default role (basic functions on the website)
- ADMIN - performs administrative and management functions

## External APIs
- [Email API](https://github.com/maildev/maildev)

### Setting Up a Project (independent terminals)
Spring boot
```
Run/Debug Configuration
In scope Build and run add com.coctails.CoctailsApplication
```

Angular (localhost:4200):
```
cd /client/src/app
ng serve
```

Maildev (0.0.0.0:1080):
```
maildev
```

## 🗞️ App preview
![Zrzut ekranu 2023-01-19 o 10 44 42](https://user-images.githubusercontent.com/75738398/213409205-474c34d3-941e-4be5-a44d-3bc471413eb3.png)

## 🔒 Environment variables
> **Note** Check out `application.properties` and `application.yml` files

## IMPORTANT
Application is being updated every week. Check change.log for more details what has been changes
It's not final version of readmie.
