import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ErrorsOverviewPageComponent } from "./pages/errors-overview-page/errors-overview-page.component";

const routes: Routes = [
    {path: "", pathMatch: "full", component: ErrorsOverviewPageComponent}
];

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class ErrorsRoutingModule {

}
