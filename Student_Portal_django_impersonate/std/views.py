import random
import smtplib

from django.contrib.auth import get_user_model
from django.contrib.auth.forms import UserCreationForm
from django.core.mail import send_mail
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render

# Create your views here.
from django.urls import reverse_lazy
from django.views.generic import CreateView, UpdateView, DeleteView, DetailView, ListView

from std.models import Student, StdForm


class Userregister(CreateView):
    template_name = "signup.html"
    form_class = UserCreationForm
    success_url = reverse_lazy("login",)


# class CBV(ListView):
#     model = Student
#     template_name = 'Test_Cases.html'
#     context_object_name = "Yo_Boy"


class GeT(DetailView):
    model = Student
    template_name = 'd1.html'
    queryset = Student.objects.all()


class Create(CreateView):
    form_class = StdForm
    template_name = '1yo.html'
    queryset = Student.objects.all()
    success_url = reverse_lazy('std:welcome')


class Update(UpdateView):
    template_name = 'yo2.html'
    fields = '__all__'
    # ['name','']
    # form_class = TestModel
    queryset = Student.objects.all()
    success_url = reverse_lazy("std:welcome")


class Delete(DeleteView):
    template_name = 'yo3.html'
    model = Student
    success_url = reverse_lazy('std:welcome')

def sample(requets):
    return HttpResponseRedirect("/acc/login/")


def welc(request):
    obj=Student.objects.all()

    user = request.user

    if user.is_anonymous:
        return HttpResponseRedirect("/acc/login/")

    Userr = get_user_model()

    User_detail = Userr.objects.get(id=user.id)
    context = {"obj":obj}

    if not user.is_superuser:
            details = Student.objects.get(User_id=user.id)
            context ={"obj":obj,"User":details,"Std":User_detail}


    return render(request,'Welcome.html',context=context)


def sendd_mail(request):
    smtpserver = 'smtp.gmail.com'
    SENDER = 'jdkamdar98@gmail.com'
    RECIPIENTS = 'harshittrivedi8691@gmail.com'
    OTP=random.randrange(1000,9999)
    mssg = "Your OTP For Registration is "+OTP
    server = smtplib.SMTP(smtpserver, 587)
    server.ehlo()
    server.starttls()
    server.ehlo()
    server.login('jdkamdar98@gmail.com', 'go')
    server.set_debuglevel(1)
    server.sendmail(SENDER, [RECIPIENTS], mssg)
    server.quit()
    return render(request,'Welcome.html',{"otp":OTP})


    # send_mail("OTP Generation","Here is OTP 1124","harshittrivedi8691@gmail.com",["jdkamdar98@gmail.com"],fail_silently=False,auth_user='harshittrivedi8691@gmail.com',auth_password='RKhp@2324')
    # return HttpResponse("<h1>successfulyy</h1>")


