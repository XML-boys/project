import {Component, Inject, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ReservationsService} from '../services/reservations.service';
import {LoginServiceService} from '../services/login-service.service';
import {MessageService} from '../services/message.service';
import {DOCUMENT} from '@angular/common';
import {ClientService} from '../services/client.service';

@Component({
  selector: 'app-client-chat',
  templateUrl: './client-chat.component.html',
  styleUrls: ['./client-chat.component.css']
})
export class ClientChatComponent implements OnInit {
  conversations: any = [];
  online: any = [];
  reservations: any = [];
  ads: any = [];

  selected = '';
  conID;
  curentuser = '';
  messages: any = [];
  constructor(@Inject(DOCUMENT) document, private router: Router, private reservationsService: ReservationsService,
              private messageService: MessageService, private loginService: LoginServiceService,
              private clientService: ClientService) { }

  ngOnInit(): void {
    this.reservations = this.clientService.uzmiRezervacije();
    this.ads = this.clientService.uzmiAds();
    console.log(this.reservations);
    console.log(this.ads);
    this.messageService.getConversations().subscribe(data2 => {

    for (const reservation of this.reservations) {
      for (const ad of this.ads) {
        for (const res of ad.reservations) {
          if (res === reservation) {
              for (const tmp2 of data2) {
                if (res.id === tmp2.orderId) {
                  this.messageService.getUser(ad.idAgenta).subscribe(userData => {
                    const user = {
                      id: tmp2.id,
                      username: userData.username
                    };
                    this.online.push(user);
                    console.log(this.online);

                  });
                }
              }
            }

          }

        }
      }
    });
    this.loadMessages();

  }

  // tslint:disable-next-line:typedef
  loadMessages() {
    this.messageService.getMassages().subscribe(mesData => {
      this.messages = mesData;
      console.log('messages: ' + mesData);
    });
  }


  // tslint:disable-next-line:typedef
  proba(a) {
    console.log(a);
    this.selected = a.username;
    this.conID = a.id;
  }

  // tslint:disable-next-line:typedef
  send() {
    console.log('okidaa');
    const message = {
      fromUser: this.curentuser,
      toUser: this.selected,
      content: (document.getElementById('messageField')as HTMLInputElement).value,
      conversationId: this.conID
    };
    this.messageService.sendMessage(message).subscribe(
      Dt => {
        this.loadMessages();
      }
    );
    console.log('sent : ' + message);
  }

}
