package mocks

//Create a custom exception in kotlin
class ErrorMock(fileName: String) : Exception(fileName) {
    override fun toString(): String {
        return "File not found: $message"
    }
}