import { Component, onInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements onInit{

	parkings : any[] = [];

  constructor(private http : HttpClient) {

  }

  ngOnInit() {
  	this.http.get("http://locathost:8080/api/parkings").subscribe((data : any[]) => {
  		this.parkings = data;
  	});
  }

  addData(parking : any) {
  	this.http.post("http://locathost:8080/api/parkings").subscribe((data : any) => {
  		console.log(data);
  	});
  }

}
