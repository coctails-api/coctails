export class User {
  login: string;
  email: string;
  password: string;
  phone: string;

  constructor(login: string, email: string, password: string, phone: string) {
    this.login = login;
    this.email = email;
    this.password = password;
    this.phone = phone;
  }
}
