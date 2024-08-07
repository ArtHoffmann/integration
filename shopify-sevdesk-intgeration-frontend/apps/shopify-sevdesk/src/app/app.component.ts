import {Component, OnInit} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  standalone: true,
  imports: [RouterModule, NgIf, AsyncPipe, NgForOf],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {

  ngOnInit(): void {
    console.log("app component loaded")
  }

}
