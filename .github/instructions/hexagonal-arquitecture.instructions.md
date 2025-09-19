---
applyTo: '**/*.java'
description: Hexagonal Architecture Guidelines
author: Paul Vidal (pvandriod93@gmail.com)
version: 1.0.0
tags: ['architecture', 'hexagonal', 'clean code']
priority: high
---

## 🧱 Instrucciones para GitHub Copilot

### 🎯 Objetivo
Generar código que respete la arquitectura hexagonal, separando claramente las responsabilidades en capas: **Domain**, **Application**, **Infrastructure**, y **Base**.

---

## 🧩 Estructura de Capas

### 1. **Domain**
- Contiene la lógica de negocio pura.
- Clases:
  - Entidades
  - Modelo de base de datos
  - Enums
  - Entidades de configuraciónn de Beans
  - Excepciones personalizadas

### 2. **Application**
- Orquesta los casos de uso.
- Clases:
  - Servicios de aplicación
  - Puertos
  - Validadores

### 3. **Infrastructure**
- Implementa los adaptadores externos.
- Clases:
  - Repositorios JPA
  - Controladores REST
  - Configuraciones
  - Adaptadores de entrada/salida
  - Dtos
  - Mappers

### 4. **Shared**
- Utilidades compartidas.
- Clases:
  - Excepciones
  - Utilitarios
  - Clases comunes

---

## 📁 Esquema de Carpetas

```plaintext
src/
└── main/
    └── java/
        └── com/
            └── ejemplo/
                ├── shared/
                │   ├── constant/
                │   └── util/
                │
                ├── domain/
                │   ├── model/
                │   │   └── entity/
                │   │       └── enum/
                │   ├── config/
                │   └── exception/
                │
                ├── application/
                │   ├── port/
                │   │    ├── input/
                │   │    └── output/
                │   ├── service/
                │   └── validator/
                │
                └── infrastructure/
                    └─── adapter/
                        ├── input/
                        |   ├── mapper/
                        |   ├── dto/
                        |   ├── config/
                        │   └── rest/
                        └── output/
                            ├── config/
                            ├── dto/
                            └── repository/
