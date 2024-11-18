import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaisesService {

  private API_SERVER = "http://localhost:8080";

  constructor(
    private httpClient : HttpClient
  ) { }
}
