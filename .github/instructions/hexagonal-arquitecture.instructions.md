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
  - Value Objects
  - Interfaces de repositorios (Ports)
  - Interfaces de servicios (Ports)

### 2. **Application**
- Orquesta los casos de uso.
- Clases:
  - Servicios de aplicación
  - DTOs
  - Mappers
  - Validadores

### 3. **Infrastructure**
- Implementa los adaptadores externos.
- Clases:
  - Repositorios JPA
  - Controladores REST
  - Configuraciones
  - Adaptadores de entrada/salida

### 4. **Base**
- Utilidades compartidas.
- Clases:
  - Excepciones
  - Utilitarios
  - Clases comunes
  - Configuración base

---

## 📁 Esquema de Carpetas

```plaintext
src/
└── main/
    └── java/
        └── com/
            └── ejemplo/
                ├── base/
                │   ├── config/
                │   ├── exception/
                │   └── util/
                │
                ├── domain/
                │   ├── model/
                │   ├── port/
                │   │   ├── in/
                │   │   └── out/
                │   └── service/
                │
                ├── application/
                │   ├── service/
                │   ├── dto/
                │   ├── mapper/
                │   └── validator/
                │
                └── infrastructure/
                    ├── adapter/
                    │   ├── in/
                    │   │   └── rest/
                    │   └── out/
                    │       └── persistence/
                    ├── config/
                    └── repository/
