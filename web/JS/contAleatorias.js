/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//generar una variable generatePassword
const generatePassword = (base, length) => {
    let password = "";
    for (let x = 0; x < length; x++) {//elegir el tamaño que quiera 
        let random = Math.floor(Math.random() * base.length);
        password += base.charAt(random);
    }
    return password; // retorne la contraseña
};

const generate = () => {
    let length = parseInt(inputLength.value);
    
    let base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const numbers = "0123456789";
    const symbols = ".?,;-_¡!¿*%&$/()[]{}|@><";

    if (checkbox1.checked) base += numbers;

    if (checkbox2.checked) base += symbols;

    generatedPassword.innerText = generatePassword(base, length);
};

window.addEventListener("DOMContentLoaded", () => {
    btnGenerate.addEventListener("click", () => {
        generate();
    });
});