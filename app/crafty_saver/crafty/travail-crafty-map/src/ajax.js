'use strict'
var Ajax = {
	ServerUrl : 'http://localhost:8080/serverSimPol',
	hackurl : '?login=user1&token=0000&backup=1',
	
	// fonction pricipale
	ajax : function(route,method,success,error,param){
		$.ajax({
			url:this.ServerUrl+route+this.hackurl,
			success:success
		})
		
	
	},
	// recupere toutes les backupconstructions du backup si  deja en session
	getBackupConstructions : function(success){
		this.ajax('/backupconstructions','GET',success);
	},
	// recupere tous les type de constructions du backup si  deja en session
	getConstructions : function(success){
		this.ajax('/constructions','GET',success);
	}
	
};