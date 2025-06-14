# Usar OpenJDK 17 con Debian como base
FROM openjdk:17-jdk-slim-bullseye

# Instalar Tomcat
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
RUN mkdir -p "$CATALINA_HOME"
WORKDIR $CATALINA_HOME

# Instalar herramientas necesarias
RUN apt-get update && \
    apt-get install -y curl ant default-jdk && \
    rm -rf /var/lib/apt/lists/*

# Descargar y configurar Tomcat
RUN curl -fsSL https://downloads.apache.org/tomcat/tomcat-9/v9.0.105/bin/apache-tomcat-9.0.105.tar.gz | tar xzf - \
    --strip-components=1 \
    && rm bin/*.bat \
    && rm bin/*.tar.gz

# Configurar el directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el código fuente
COPY . .

# Dar permisos de ejecución a los scripts
RUN chmod +x ./nbproject/build-impl.xml
RUN chmod +x ./build.xml

# Mostrar el contenido del directorio para debugging
RUN ls -la
RUN pwd

# Construir el proyecto con Ant en modo verbose y debug
RUN ant -verbose -debug

# Copiar el WAR generado al directorio webapps de Tomcat
RUN cp dist/finalDeVerdad.war $CATALINA_HOME/webapps/ROOT.war

# Exponer el puerto 8080
EXPOSE 8080

# Iniciar Tomcat
CMD ["catalina.sh", "run"] 