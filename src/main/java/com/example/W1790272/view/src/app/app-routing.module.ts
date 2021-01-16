import { HomeComponent } from './home/home.component';
import { HelpComponent } from './help/help.component';
import { MatchComponent } from './match/match.component';
import { ClubComponent } from './club/club.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path:'club', component:ClubComponent},
  {path:'match',component:MatchComponent},
  {path:'help',component:HelpComponent},
  {path:'home',component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

