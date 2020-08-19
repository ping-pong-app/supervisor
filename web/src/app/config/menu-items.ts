import { MenuItem } from "../../models";

export const menuItems: MenuItem[] = [
    {
        label: "Errors",
        url: "/errors",
        external: false,
    },
    {
        label: "Users",
        url: "/users",
        external: false,
    },
    {
        label: "Swagger",
        url: "https://api.pinger.group/openapi/ui",
        external: true,
    },
];
