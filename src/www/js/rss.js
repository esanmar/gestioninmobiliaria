/* rss.js by Jay Eckles - www.jayeckles.com <j.eckles@computer.org> */
function JERSSitem(){
   this.title ;
   this.description ;
   this.link ;
}

function JERSSitem( t, d, l ){
   this.title = t ;
   this.description = d ;
   this.link = l ;
}

function JERSSchannel(){
   this.title ;
   this.description ;
   this.link ;
   this.editor ;
   this.webmaster ;
   this.copyright ;
   this.language ;
}

function JERSSchannel( t, d, l, e, w, c, ln ){
   this.title = t ;
   this.description = d ;
   this.link = l ;
   this.editor = e ;
   this.webmaster = w ;
   this.copyright = c ;
   this.language = ln ;
}