const loginDropdownBox = document.querySelector('.main-login-dropdown-box');
const dropList = document.querySelector('#main-login-display');
const loginCommu = document.querySelector('.main-login-commu');
const loginCommuSub = document.querySelector('.main-login-commu-sub');
const dropDown = document.querySelector('.main-header-user-box');
const loginUserElement = document.querySelector('.main-header-dropdown-container');
const mainPageNavBar = document.querySelector('.main-header-container');


if(dropDown) {
  dropDown.addEventListener('click', (event) => {
    const target = event.target;
    if(target.tagName.toLowerCase() === 'i') {
      const dropDownMenu = document.querySelector('.main-header-dropdown');
      if(target.classList.contains('icon-down-dir')) {
        target.classList.remove('icon-down-dir');
        target.classList.add('icon-up-dir');
        dropDownMenu.style.display = 'flex';
      } else if(target.classList.contains('icon-up-dir')) {
        target.classList.remove('icon-up-dir');
        target.classList.add('icon-down-dir');
        dropDownMenu.style.display = 'none';
      }
    }
  });
}