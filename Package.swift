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
         checksum:"01945ad70109f3bb68e134c1ca40350232d4d8ff5dc79f784b479d88db9012a6")
   ]
)