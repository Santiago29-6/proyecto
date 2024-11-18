import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { EstadosService } from './services/estados/estados.service';
import { PaisesService } from './services/paises/paises.service';
import { PersonaService } from './services/persona/persona.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule, 
    RouterOutlet,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  personaForm!: FormGroup;

  paises: any;

  constructor(
    public fb: FormBuilder,
    public estadosService : EstadosService,
    public paisesService : PaisesService,
    public personaService : PersonaService
  ){

  }
  ngOnInit(): void {
    this.personaForm = this.fb.group({
      nombre : ['', Validators.required],
      apellido : ['', Validators.required],
      edad : ['', Validators.required],
      pais : ['', Validators.required],
      estado : ['', Validators.required]
    });
    this.paisesService
  }

  guardar():void{

  }
}
