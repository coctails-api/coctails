export class UserForm {
  login: string;
  password: string;
  email: string;
  phone: string;

  constructor(login: string = '', password: string = '', email: string = '', phone: string = '') {
    this.login = login;
    this.password = password;
    this.email = email;
    this.phone = phone;
  }
}
