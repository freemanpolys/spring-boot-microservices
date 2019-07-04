import {Component, OnInit} from '@angular/core';
import {ApiService} from './api.service';
import {School} from './school';
import {Student} from './student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'front';

  schoolList : Array<School> ;
  studentlList : Array<Student> ;
  updateSchool : School;
  newStudent: Student;

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.updateSchool = new School();
    this.loadAllSchool();
    this.loadAllStudent();
    this.newStudent = new Student();

  }


  deleteSchool(id: number) {
    this.apiService.delSchool(id).subscribe((res) => {
      this.loadAllSchool();
      this.loadAllStudent();
    });
  }

  updateSchoolData() {
    console.log("===="+ JSON.stringify(this.updateSchool));
    this.apiService.saveSchool(this.updateSchool).subscribe( (re) => {
      this. loadAllSchool();
      this.loadAllStudent();
    });
    this.updateSchool = new School();


  }

  private loadAllSchool() {
    this.apiService.getSchoolList().subscribe((res) => {
      this.schoolList = res;
      //console.log(this.schoolList);
    });
  }

  private loadAllStudent() {
    this.apiService.getStudentList().subscribe((res) => {
      this.studentlList = res;
      //console.log(this.studentlList);
    });
  }

  selectSchool(school: School) {
    this.updateSchool = school;
  }

  addNewStudent() {
    this.apiService.saveStudent(this.newStudent).subscribe( (re) => {
      this.loadAllStudent();
    });
    this.newStudent = new Student();

  }

  deleteStudent(id: number) {
    this.apiService.delStudent(id).subscribe((res) => {
      this.loadAllStudent();
    });
  }
}
