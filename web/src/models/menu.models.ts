import { IconProp } from "@fortawesome/fontawesome-svg-core";

export interface MenuItem {
    label: string;
    desc?: string;
    url: string;
    external?: boolean;
    icon?: IconProp;
    /*requireAuth?: boolean;
    requiredRoles?: string[];*/
}
