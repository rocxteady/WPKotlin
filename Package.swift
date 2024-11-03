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
         url: "https://github.com/rocxteady/WPKotlin/releases/download/0.0.1/WPKotlin.xcframework.zip",
         checksum:"0ea47a8b2e484eb160d539191b683f24495a886fd8176c88bbefcffe80e8ca29")
   ]
)