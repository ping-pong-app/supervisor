export interface ApiConfig {
    url: string;
    apiKey?: string;
}

export interface AppEnv {
    production: boolean;
    keycloak: {
        url: string;
        realm: string;
        clientId: string;
    };
    apis: { [apiName: string]: ApiConfig };
}
