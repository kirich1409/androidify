# Флаги gradle.properties для AGP 9

## Уже настроено (оставить как есть)

| Флаг | Значение | Назначение |
|------|----------|------------|
| `android.useAndroidX` | true | Использование AndroidX |
| `android.nonTransitiveRClass` | true | R-класс только из своего модуля (рекомендуется) |
| `android.disableMinifyLocalDependenciesForLibraries` | true | Не минифицировать локальные зависимости в библиотеках |
| `kotlin.code.style` | official | Стиль кода Kotlin |
| `org.gradle.configuration-cache` | true | Кэш конфигурации Gradle (быстрее сборка) |
| `org.gradle.caching` | true | Кэширование задач |
| `org.gradle.parallel` | true | Параллельная сборка |
| `android.experimental.enableScreenshotTest` | false | Скриншот-тесты отключены |

## Рекомендуется включить (опционально)

| Флаг | Значение | Зачем |
|------|----------|--------|
| `android.nonFinalResIds` | true | Нужен, если библиотеки обращаются к полям R через рефлексию; при `nonTransitiveRClass=true` иногда обязателен |
| `android.enableJetifier` | false | Отключить Jetifier, если все зависимости уже на AndroidX (ускоряет сборку) |

## Рекомендуется выключить / не трогать

- **Не добавлять** флаги совместимости AGP 9: `android.newDsl`, `android.builtInKotlin`, `android.sourceset.disallowProvider`, `android.disallowKotlinSourceSets` — проект уже без них.
- **android.enableR8.fullMode** — по умолчанию true в AGP 8+; отдельно не задавать, если не нужна явная настройка.

## CI (.github/ci-gradle.properties)

| Флаг | Значение | Назначение |
|------|----------|------------|
| `org.gradle.daemon` | false | В CI демон не нужен |
| `kotlin.incremental` | false | Стабильная воспроизводимая сборка в CI |
| `kotlin.compiler.execution.strategy` | in-process | Один процесс компиляции Kotlin |

## Ссылки

- [Configure build (gradle.properties)](https://developer.android.com/build/release/gradle-plugin-api-changes)
- [AGP 9 migration](https://developer.android.com/build/release/agp-9-0-0-migration-guide)
