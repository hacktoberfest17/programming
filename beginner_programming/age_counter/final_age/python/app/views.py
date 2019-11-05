# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render
from models import BirthDate
from forms import MainForm
from datetime import date
# Create your views here.

def add_birthdate(request):
	if (request.method == 'POST'):
		form = MainForm(request.POST)

		if form.is_valid():
			form.save()

			return fun(request)
		else:
			print form.errors
	else:
		form = MainForm()
	return render(request, 'add_birthdate.html', {'form' : form})


def fun(request):
	try:
		birthdate = BirthDate.objects.order_by('-id')[0]
		#print type(birthdate)
		year = int(str(birthdate)[0:4])
		month = int(str(birthdate)[5:7])
		day = int(str(birthdate)[8:10])
		data = {'year' : year, 'month' : month, 'day' : day}
		age = calculate_age(data)
		return render(request, 'fun.html', {'birthdate' : birthdate, 'age': age})
	except:
		#add_birthdate()
		#return render(request, 'add_birthdate.html', {})
		return add_birthdate(request)

def calculate_age(data):
    today = date.today()
    return today.year - data['year'] - ((today.month, today.day) < (data['month'], data['day']))