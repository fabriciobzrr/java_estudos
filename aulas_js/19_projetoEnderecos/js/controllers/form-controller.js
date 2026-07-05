import Address from "../models/address.js";
import * as addressService from "../services/address-service.js";
import * as listController from "./list-controller.js";

function State() {
  this.address = new Address();

  this.btnSave = null;
  this.btnClear = null;

  this.inputCep = null;
  this.inputStreet = null;
  this.inputNumber = null;
  this.inputCity = null;

  this.errorCep = null;
  this.errorNumber = null;
}

const state = new State();

export function init() {
  state.inputCep = document.forms.newAddress.cep;
  state.inputStreet = document.forms.newAddress.street;
  state.inputNumber = document.forms.newAddress.number;
  state.inputCity = document.forms.newAddress.city;

  state.btnSave = document.forms.newAddress.btnSave;
  state.btnClear = document.forms.newAddress.btnClear;

  state.errorCep = document.querySelector('[data-error="cep"]');
  state.errorNumber = document.querySelector('[data-error="number"]');

  state.inputNumber.addEventListener("change", handleInputNumberChange);
  state.inputNumber.addEventListener("keyup", handleInputNumberKeyUp);
  state.btnClear.addEventListener("click", handleBtnClearClick);
  state.btnSave.addEventListener("click", handleBtnSaveClick);
  state.inputCep.addEventListener("change", handleInputCepChange);
}

function handleInputNumberKeyUp(e) {
  state.address.number = e.target.value;
}

async function handleInputCepChange(e) {
  const cep = e.target.value;

  try {
    const address = await addressService.findByCep(cep);

    state.inputCity.value = address.city;
    state.inputStreet.value = address.street;
    state.address = address;

    setFormError("cep", "");
    state.inputNumber.focus();
  } catch (e) {
    state.inputStreet.value = "";
    state.inputCity.value = "";
    setFormError("cep", "O número do CEP é inválido!");
  }
}

function clearForm() {
  state.inputCep.value = "";
  state.inputStreet.value = "";
  state.inputNumber.value = "";
  state.inputCity.value = "";

  setFormError("cep", "");
  setFormError("number", "");

  state.address = new Address();

  state.inputCep.focus();
}

function handleBtnClearClick(e) {
  e.preventDefault();
  clearForm();
}

function handleBtnSaveClick(e) {
  e.preventDefault();
  const errors = addressService.getErrors(state.address);

  const keys = Object.keys(errors);

  if (keys.length > 0) {
    keys.forEach((key) => {
      setFormError(key, errors[key]);
    });
  } else {
    listController.addCard(state.address);
    clearForm();
  }
}

function handleInputNumberChange(e) {
  if (e.target.value === "") {
    setFormError("number", "Campo obrigatório!");
  } else {
    setFormError("number", "");
  }
}

function setFormError(error, message) {
  const element = document.querySelector(`[data-error="${error}"]`);
  element.innerHTML = message;
}
