import { NgModule } from "@angular/core";
import { StyleModule } from "./style.module";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        StyleModule
    ],
    exports: [
        StyleModule,
    ]
})
export class SharedModule {

}
