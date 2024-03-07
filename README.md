# Lab 05

## Tabla de Contenidos
- [Integrantes](#integrantes)
- [Respuestas](#respuestas)

## Integrantes
- Joan Steven Acevedo
- Miguel Ángel González Mahecha

## Respuestas

### Parte II
- ¿Qué hace cada uno de los archivos en la aplicación?
```
  .
  ├── package.json              # contiene info sobre el proyecto y sus dependencias
  ├── public                    # Contiene archivos estáticos
  │   └── index.html            # El documento html que se sirve al cliente
  └── src                       # Código fuente
  ├── App.js                    # Utiliza JSX y los componentes para formar la calculadora
  ├── components                # Contiene los componentes reutilizables
  │   ├── KeyPadComponent.js    # Define el teclado de la calculadora cómo componente
  │   └── ResultComponent.js    # Define el espacio de resultado cómo componente
  ├── index.js                  # Inicializa React tomando el div con ID 'root'.
  └── styles.css                # Define los estilos que se aplican a los elementos html
```

Descargamos el código y ejecutamos ```npm install```. Este comando toma las dependencias declaradas en el
```package.json``` y las instala localmente.

Para correr la aplicación usando PowerShell:
```powershell
$env:NODE_OPTIONS='--openssl-legacy-provider' ; npm run start
```
En bash:
```shell
NODE_OPTIONS=--openssl-legacy-provider npm run start
```

- ¿El contenido que se sirve al usuario es dinámico o estático?
Al hacer una solicitud GET a http://localhost:3000 resivimos un HTML que solo difiere de ```public/index.html``` en
4 líneas del body
```html
<body>
<noscript>
    You need to enable JavaScript to run this app.
</noscript>
<div id="root"></div>
<!--
  Estas 4 script tags no están en el archivo public/index.html. Son agregadas por react.
-->
<script src="/static/js/bundle.js"></script>
<script src="/static/js/1.chunk.js"></script>
<script src="/static/js/main.chunk.js"></script>
<script src="/main.9efaefbf9dfe58338292.hot-update.js"></script>
</body>
```