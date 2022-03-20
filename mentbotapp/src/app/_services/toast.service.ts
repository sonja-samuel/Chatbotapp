// import { Injectable } from '@angular/core';
// // import Swal from 'sweetalert2';

// @Injectable({
//   providedIn: 'root'
// })
// export class ToastService {


//   async openSweetAlertToast(toastType:any,toastMessage:any):Promise<void> {
//     const Toast = Swal.mixin({
// 		toast: true,
// 		position: 'top-right',
// 		iconColor: 'white',
// 		customClass: {
// 		  popup: 'colored-toast'
// 		},
// 		showConfirmButton: false,
// 		timer: 4000,
// 		// timerProgressBar: true,
//     showCloseButton: true,
// 	  })
//     if(toastType === 'Error'){
//       await Toast.fire({
//         icon: 'error',
//         title: toastMessage,
//         })
//     }
//     if(toastType === 'Success'){
//       await Toast.fire({
//         icon: 'success',
//         title: toastMessage,
//         })
//     }
//     if(toastType === 'Warning'){
//       await Toast.fire({
//         icon: 'warning',
//         title: toastMessage,
//         })
//     }
	  
//   }
// }
