import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { UsersOverviewPageComponent } from "./pages/users-overview-page/users-overview-page.component";


const routes: Routes = [
    {path: "", pathMatch: "full", component: UsersOverviewPageComponent}
];

@NgModule({
    imports: [
        RouterModule.forChild(routes),
    ],
    exports: [
        RouterModule
    ]
})
export class UsersRoutingModule {

}
