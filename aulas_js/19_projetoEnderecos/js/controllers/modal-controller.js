function State() {
  this.modal = null;
  this.btnClose = null;
}

const state = new State();

export function init() {
  state.modal = document.querySelector("#modal-contanct");
  state.btnClose = document.querySelector("#modal-contanct .btn");
  state.btnClose.addEventListener("click", handleBtnCloseClick);

  state.modal.addEventListener("click", handleModalClick);
}

export function openModal() {
  state.modal.classList.add("active");
}

export function closeModal() {
  state.modal.classList.remove("active");
}

function handleModalClick(e) {
  e.preventDefault();
  if (e.target === state.modal) {
    closeModal();
  }
}

function handleBtnCloseClick(e) {
  e.preventDefault();
  closeModal();
}
