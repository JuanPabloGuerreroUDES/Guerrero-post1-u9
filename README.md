# Recordatorios Citas Service

Post-contenido Unidad 9 — Probar el Diseño: JUnit 5, Mockito, Test Doubles e Integración Continua.

## Parte 1 — Pruebas Unitarias con JUnit 5 y Mockito

`CitaReminderServiceImpl` recibe por constructor sus tres colaboradores (`CitaRepository`,
`ReminderChannelFactory` y `Clock`). `CitaReminderServiceImplTest` lo aísla por completo de ellos.

## Decisiones de diseño (Parte 1)

| Colaborador | Test Double | Justificación |
|---|---|---|
| `CitaRepository` | **Mock** | La prueba controla la respuesta de `findBy...` **y** verifica que `save()` se llame una vez con la cita marcada como enviada. |
| `ReminderChannelFactory` / `ReminderChannel` | **Mock** | Lo que se prueba es la selección de estrategia; solo es observable verificando la interacción. |
| `Clock` | **Fake** (`Clock.fixed`) | El JDK ya trae una implementación real y completa con el instante congelado; mockearlo sería más frágil. |

## Ejecutar las pruebas

```bash
mvn test
```
