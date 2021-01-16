import { MatchComponent } from './match/match.component';
import { HomeComponent } from './home/home.component';
import { HelpComponent } from './help/help.component';
import { ClubComponent } from './club/club.component';
import { MatchSerService } from './match/match-ser.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
   ClubComponent,
   HelpComponent,
   HomeComponent,
   MatchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule

  ],
  providers: [MatchSerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
