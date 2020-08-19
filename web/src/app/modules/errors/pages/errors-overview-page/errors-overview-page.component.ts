import { Component, OnInit } from "@angular/core";
import { Seo } from "../../../../services/seo.service";

@Component({
    selector: "app-errors-overview-page",
    templateUrl: "./errors-overview-page.component.html",
    styleUrls: ["./errors-overview-page.component.scss"]
})
export class ErrorsOverviewPageComponent implements OnInit {

    constructor(private seo: Seo) {
    }

    ngOnInit(): void {
        this.seo.setPageTitle("Errors");
    }

}
