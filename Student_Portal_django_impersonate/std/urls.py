"""Student_Portal URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url, include

from std import views

app_name="std"

urlpatterns = [
    # url(r'^home/',),
    # url(r'^ALL',views.CBV.as_view(),name="all"),
    url(r'^detail/(?P<pk>\d+)',views.GeT.as_view(),name='details'),
    url(r'^create/',views.Create.as_view(),name="add"),
    url(r'^update/(?P<pk>\d+)',views.Update.as_view(),name="update"),
    url(r'^delete/(?P<pk>\d+)',views.Delete.as_view(),name="dlete"),
    url(r'^signup/',views.Userregister.as_view(),name="signup"),
    url(r'^std/welcome/',views.welc,name='welcome'),
    url(r'',views.sample),
    # url(r'^mail',views.sendit,name="mail"),
    # url(r'^about/',),
]
