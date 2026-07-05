const texto = "3223223";

function reverseText(text) {
  const textFormat = text
    .normalize("NFD")
    .replace(/[^a-z0-9]/gi, "")
    .replace(/[\u0300-\u036f]/g, "")
    .toLowerCase();
  const newText = textFormat.split("").reverse().join("");
  return textFormat === newText ? "Palindromo" : "Não Palindromo";
}

console.log(reverseText(texto));
