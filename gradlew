#!/bin/bash
# gradlew (simplificado para teste de CI)

set -e

# Este comando simula a chamada do gradle
# Em um projeto real, ele baixaria o Gradle, mas aqui vamos forçar o uso do comando direto
echo "Iniciando build via Wrapper simulado..."
./gradlew assembleDebug
