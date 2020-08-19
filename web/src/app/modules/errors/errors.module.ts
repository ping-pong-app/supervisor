import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ErrorsRoutingModule } from "./errors-routing.module";
import { ErrorsOverviewPageComponent } from "./pages/errors-overview-page/errors-overview-page.component";


@NgModule({
    imports: [
        CommonModule,
        ErrorsRoutingModule,
    ],
    declarations: [
        ErrorsOverviewPageComponent,
    ]
})
export class ErrorsModule {

}
