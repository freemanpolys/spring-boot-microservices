import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {School} from './school';
import {Student} from './student';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiURL: string = 'http://192.168.50.1:8080/api';

  constructor(private httpClient: HttpClient) {}

  public getSchoolList(){
    return this.httpClient.get<School[]>(`${this.apiURL}/school/list`);
  }
  public saveSchool(school : School){
    return this.httpClient.post<School>(`${this.apiURL}/school/save`,school);
  }

  public delSchool(id :number){
    return this.httpClient.delete(`${this.apiURL}/school/delete/${id}`);
  }

  public getStudentList(){
    return this.httpClient.get<Student[]>(`${this.apiURL}/student/list`);
  }

  public saveStudent(student : Student){
    return this.httpClient.post<Student>(`${this.apiURL}/student/save`,student);
  }


  public delStudent(id :number){
    return this.httpClient.delete(`${this.apiURL}/student/delete/${id}`);
  }

}
