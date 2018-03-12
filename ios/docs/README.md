# iOS Example

Exemplos de uso e funcionalidades do SDK iOS sobre a plataforma _fluig_.

## Funcionalidades

O projeto de exemplo do [fluig SDK iOS](https://github.com/fluig/fluigsdkios) possui as seguintes funcionalidades:
* [Fluxos](#fluxos)
* [Componentes de interface](#componentes)

### Fluxos

Os fluxos com exemplo implementados estão marcados abaixo.

- [x] Login
- [x] Termos de Uso

Para visualizar como são iniciados os fluxos, siga os passos a seguir:
1. Acesse a classe [`MainViewController`](../Example/Example/Controllers/Main/MainViewController.swift).
2. Procure pelo método corresponde ao fluxo desejado.
    * `showLoginFlow()` para Login
    * `showEulaFlow()` para Termos de Uso

### Componentes

Os compoenentes com exemplo implementados estão marcados abaixo.

- [x] `FluigSDKButton`
- [x] `FluigSDKLoadingView`
- [x] `FluigSDKMediaView`
- [ ] `FluigSDKPopUpView`
- [x] `FluigSDKProfilePic`
- [x] `FluigSDKTextField`
- [x] `FluigSDKTextFieldGroup`

Para visualizar como os componentes são criados e alterados, há duas maneiras:
* Através de classes `Provider` no caso de componentes que não necessitam ocupar a tela inteira. Neste caso, procure pelo método `provideComponent()`.
    * [`ButtonProvider`](../Example/Example/Controllers/Component/Providers/ButtonProvider.swift) para `FluigSDKButton`.
    * [`TextFieldProvider`](../Example/Example/Controllers/Component/Providers/TextFieldProvider.swift) para `FluigSDKTextField`.
    * [`TextFieldGroupProvider`](../Example/Example/Controllers/Component/Providers/TextFieldGroupProvider.swift) para `FluigSDKTextFieldGroup`.
    * [`ProfilePicProvider`](../Example/Example/Controllers/Component/Providers/ProfilePicProvider.swift) para `FluigSDKProfilePic`.

* Através de classes `View` nos outros casos. Por padrão, tente procurar pelo método `setupComponent()`.
    * [`MediaView`](../Example/Example/Controllers/Component/Views/MediaView.swift) para `FluigSDKMediaView`.
