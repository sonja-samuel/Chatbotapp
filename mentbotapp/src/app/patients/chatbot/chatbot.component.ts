import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { SocketService } from '../../_services/socket.service';

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrls: ['./chatbot.component.scss']
})
export class ChatbotComponent implements OnInit {
  // title = 'Simple Chatbot';
  messageArray = [];
  message= '';

  messageForm = this.fb.group({
    message: ['']
  });
  constructor(private socketService:SocketService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.socketService.receivedMessage().subscribe(data=> {
      this.messageArray.push({name:'bot', message: data.outputMessage});
    });
  }

  sendMessage(msg:string){
    const data = { message:msg };
    this.socketService.sendMessage(data);
    this.messageArray.push({name:'you', message:msg});
    msg = '';
  }

}
