// swift-tools-version:5.3
import PackageDescription

let package = Package(
   name: "WPKotlin",
   platforms: [
     .iOS(.v14),
   ],
   products: [
      .library(name: "WPKotlin", targets: ["WPKotlin"])
   ],
   targets: [
      .binaryTarget(
         name: "WPKotlin",
         url: "https://github.com/rocxteady/WPKotlin/releases/download/0.0.2/WPKotlin.xcframework.zip",
         checksum:"9ec8bc72b7d7eeab573a2fd24c09663f581e9e4e4176e2e0003642a48de29ae5")
   ]
)