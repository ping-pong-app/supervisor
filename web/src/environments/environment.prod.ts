import { AppEnv } from "./env.models";

export const environment: AppEnv = {
    production: true,
    keycloak: {
        url: "",
        realm: "",
        clientId: ""
    },
    apis: {}
};
