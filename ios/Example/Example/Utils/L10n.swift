// Generated using SwiftGen, by O.Halligon — https://github.com/SwiftGen/SwiftGen

import Foundation

// swiftlint:disable superfluous_disable_command
// swiftlint:disable file_length

// swiftlint:disable identifier_name line_length type_body_length
enum L10n {
  /// FluigSDKButton
  static let componentButton = L10n.tr("Localizable", "component_button")
  /// FluigSDKMediaView
  static let componentMediaView = L10n.tr("Localizable", "component_mediaView")
  /// FluigSDKTextField
  static let componentTextField = L10n.tr("Localizable", "component_textField")
  /// FluigSDKTextFieldGroup
  static let componentTextFieldGroup = L10n.tr("Localizable", "component_textFieldGroup")
  /// EULA
  static let flowEula = L10n.tr("Localizable", "flow_eula")
  /// Login
  static let flowLogin = L10n.tr("Localizable", "flow_login")
  /// Components
  static let listComponents = L10n.tr("Localizable", "list_components")
  /// Flows
  static let listFlows = L10n.tr("Localizable", "list_flows")
}
// swiftlint:enable identifier_name line_length type_body_length

extension L10n {
  private static func tr(_ table: String, _ key: String, _ args: CVarArg...) -> String {
    let format = NSLocalizedString(key, tableName: table, bundle: Bundle(for: BundleToken.self), comment: "")
    return String(format: format, locale: Locale.current, arguments: args)
  }
  
  public static func get(_ key: String, _ args: CVarArg...) -> String {
    let format = NSLocalizedString(key,
                                   tableName: "Localizable",
                                   bundle: Bundle(for: BundleToken.self),
                                   comment: "")
     return String(format: format, locale: Locale.current, arguments: args)
  }
}

private final class BundleToken {}
