import matplotlib.pyplot as plt
import numpy as np
import io
import base64

def create_plot():
    # 데이터 생성
    x = np.linspace(0, 10, 100)
    y = np.sin(x)

    # 그래프 생성
    plt.figure()
    plt.plot(x, y)
    plt.title('Sample Plot')
    plt.xlabel('x')
    plt.ylabel('sin(x)')

    #case1) 결과를 이미지 파일로 저장
#     plt.savefig('./src/main/resources/static/images/plot.png')

    #case2) 메모리 버퍼에 저장
    buf = io.BytesIO()
    plt.savefig(buf, format='png')
    buf.seek(0)

    # 이미지를 base64 인코딩
    img_base64 = base64.b64encode(buf.read()).decode('utf-8')
    return img_base64

if __name__ == "__main__":
    print(create_plot())
