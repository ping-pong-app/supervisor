import { NgModule } from "@angular/core";
import { FaIconLibrary, FontAwesomeModule } from "@fortawesome/angular-fontawesome";
import {
    faArrowLeft,
    faCheck, faChevronRight,
    faCogs,
    faDatabase,
    faExclamationTriangle,
    faPencilAlt,
    faPlus,
    faSearch,
    faSlidersH,
    faTimes
} from "@fortawesome/free-solid-svg-icons";
import { TooltipModule } from "ngx-bootstrap/tooltip";


@NgModule({
    imports: [
        TooltipModule.forRoot(),
        FontAwesomeModule,
    ],
    exports: [
        TooltipModule,
        FontAwesomeModule,
    ]
})
export class StyleModule {
    constructor(library: FaIconLibrary) {
        library.addIcons(
            faPlus,
            faTimes,
            faCheck,
            faCogs,
            faSlidersH,
            faDatabase,
            faExclamationTriangle,
            faChevronRight,
            faArrowLeft,
            faSearch,
            faPencilAlt
        );
    }
}
