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
         url: "https://github.com/rocxteady/WPKotlin/releases/download/0.0.3/WPKotlin.xcframework.zip",
         checksum:"59a70362c37f1132b7e9c0bb442b45ba6803391b39586a2965899a8ea7b8b555")
   ]
)