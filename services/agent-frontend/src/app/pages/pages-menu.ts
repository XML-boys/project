import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Početna',
    icon: 'home-outline',
    link: '/agent',
    home: true,
  },
  {
    title: 'Moji oglasi',
    icon: 'pricetags',
    link: '/agent/my-ads',
    home: false,
  },
];
