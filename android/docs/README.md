# Android Example

Exemplos de uso e funcionalidades do SDK Android sobre a plataforma _fluig_.

## Funcionalidades

O projeto de exemplo do [fluig SDK Android](https://dl.bintray.com/fluig/maven/sdk/fluig/com/) possui as seguintes funcionalidades:
* [Fluxos](#fluxos)
* [Componentes de interface](#componentes)

### Fluxos

Os fluxos com exemplo implementados estão marcados abaixo.

- [x] Login
- [x] Termos de Uso

Para visualizar como são iniciados os fluxos, siga os passos a seguir:
1. Acesse a classe [`MainActivity`](../Example/app/src/main/java/sdk/fluig/com/example/main/view/MainActivity.java).
2. Procure pelo método corresponde ao fluxo desejado.
    * `showLoginFlow()` para Login
    * `showEulaFlow()` para Termos de Uso

### Componentes

Os compoenentes com exemplo implementados estão marcados abaixo.

- [x] `FluigSdkButton`
- [ ] `FluigSdkDialog`
- [x] `FluigSdkEditText`
- [x] `FluigSdkGroupText`
- [x] `FluigSdkMediaView`
- [ ] `FluigSdkProfileThumb`
- [x] `FluigSdkWebView`

Para visualizar como os componentes são criados e alterados, acesse o `Fragment` correspondente. Por padrão, tente procurar pelo método `setupComponent()`.
* [`ButtonFragment`](..Example/app/src/main/java/sdk/fluig/com/example/component/view/fragment/ButtonFragment.java) para `FluigSdkButton`
* [`EditTextFragment`](..Example/app/src/main/java/sdk/fluig/com/example/component/view/fragment/EditTextFragment.java) para `FluigSdkEditText`
* [`GroupTextFragment`](..Example/app/src/main/java/sdk/fluig/com/example/component/view/fragment/GroupTextFragment.java) para `FluigSdkGroupText`
* [`MediaViewFragment`](..Example/app/src/main/java/sdk/fluig/com/example/component/view/fragment/MediaViewFragment.java) para `FluigSdkMediaView`
* [`WebViewFragment`](..Example/app/src/main/java/sdk/fluig/com/example/component/view/fragment/WebViewFragment.java) para `FluigSdkWebView`
